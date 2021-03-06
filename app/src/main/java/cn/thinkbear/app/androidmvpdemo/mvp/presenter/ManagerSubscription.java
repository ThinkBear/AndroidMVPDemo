package cn.thinkbear.app.androidmvpdemo.mvp.presenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import rx.Subscription;
import rx.exceptions.Exceptions;

/**
 * Subscription 管理类
 *
 *
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/4/5
 */

public class ManagerSubscription implements Subscription {
    private Set<Subscription> subscriptions;
    private volatile boolean unsubscribed;

    /**
     * Constructs an empty Composite subscription.
     */
    public ManagerSubscription() {
        // start empty
    }

    public ManagerSubscription(final Subscription... subscriptions) {
        this.subscriptions = new HashSet<Subscription>(Arrays.asList(subscriptions));
    }

    @Override
    public boolean isUnsubscribed() {
        return unsubscribed;
    }

    /**
     * Adds a new {@link Subscription} to this {@code CompositeSubscription} if the
     * {@code CompositeSubscription} is not yet unsubscribed. If the {@code CompositeSubscription} <em>is</em>
     * unsubscribed, {@code add} will indicate this by explicitly unsubscribing the new {@code Subscription} as
     * well.
     *
     * @param s
     *         the {@link Subscription} to add
     */
    public void add(final Subscription s) {
        if (s.isUnsubscribed()) {
            return;
        }
        if (!unsubscribed) {
            synchronized (this) {
                if (!unsubscribed) {
                    if (subscriptions == null) {
                        subscriptions = new HashSet<Subscription>(4);
                    }
                    subscriptions.add(s);
                    return;
                }
            }
        }
        // call after leaving the synchronized block so we're not holding a lock while executing this
        s.unsubscribe();
    }

    /**
     * Adds collection of {@link Subscription} to this {@code CompositeSubscription} if the
     * {@code CompositeSubscription} is not yet unsubscribed. If the {@code CompositeSubscription} <em>is</em>
     * unsubscribed, {@code addAll} will indicate this by explicitly unsubscribing all {@code Subscription} in collection as
     * well.
     *
     * @param subscriptions
     *         the collection of {@link Subscription} to add
     */
    public void addAll(final Subscription... subscriptions) {
        if (!unsubscribed) {
            synchronized (this) {
                if (!unsubscribed) {
                    if (this.subscriptions == null) {
                        this.subscriptions = new HashSet<Subscription>(subscriptions.length);
                    }

                    for (Subscription s : subscriptions) {
                        if (!s.isUnsubscribed()) {
                            this.subscriptions.add(s);
                        }
                    }
                    return;
                }
            }
        }

        for (Subscription s : subscriptions) {
            s.unsubscribe();
        }
    }

    /**
     * Removes a {@link Subscription} from this {@code CompositeSubscription}, and unsubscribes the
     * {@link Subscription}.
     *
     * @param s
     *         the {@link Subscription} to remove
     */
    public void remove(final Subscription s) {
        if (!unsubscribed) {
            boolean unsubscribe;
            synchronized (this) {
                if (unsubscribed || subscriptions == null) {
                    return;
                }
                unsubscribe = subscriptions.remove(s);
            }
            if (unsubscribe) {
                // if we removed successfully we then need to call unsubscribe on it (outside of the lock)
                s.unsubscribe();
            }
        }
    }

    /**
     * Unsubscribes any subscriptions that are currently part of this {@code CompositeSubscription} and remove
     * them from the {@code CompositeSubscription} so that the {@code CompositeSubscription} is empty and
     * able to manage new subscriptions.
     */
    public void clear() {
        if (!unsubscribed) {
            Collection<Subscription> unsubscribe;
            synchronized (this) {
                if (unsubscribed || subscriptions == null) {
                    return;
                } else {
                    unsubscribe = subscriptions;
                    subscriptions = null;
                }
            }
            unsubscribeFromAll(unsubscribe);
        }
    }

    /**
     * Unsubscribes itself and all inner subscriptions.
     */
    @Override
    public void unsubscribe() {
        if (!unsubscribed) {
            Collection<Subscription> unsubscribe;
            synchronized (this) {
                if (unsubscribed) {
                    return;
                }
                unsubscribe = subscriptions;
            }
            // we will only get here once
            unsubscribeFromAll(unsubscribe);
        }
    }

    private static void unsubscribeFromAll(Collection<Subscription> subscriptions) {
        if (subscriptions == null) {
            return;
        }
        List<Throwable> es = null;
        for (Subscription s : subscriptions) {
            try {
                s.unsubscribe();
            } catch (Throwable e) {
                if (es == null) {
                    es = new ArrayList<Throwable>();
                }
                es.add(e);
            }
        }
        Exceptions.throwIfAny(es);
    }

    /**
     * Returns true if this composite is not unsubscribed and contains subscriptions.
     *
     * @return {@code true} if this composite is not unsubscribed and contains subscriptions.
     * @since 1.0.7
     */
    public boolean hasSubscriptions() {
        if (!unsubscribed) {
            synchronized (this) {
                return !unsubscribed && subscriptions != null && !subscriptions.isEmpty();
            }
        }
        return false;
    }


    public boolean hasSubscriptionRunning(){
        if (!unsubscribed&&subscriptions!=null && !subscriptions.isEmpty()) {
            synchronized (this) {
                for (Subscription s : subscriptions) {
                    if(!s.isUnsubscribed()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
