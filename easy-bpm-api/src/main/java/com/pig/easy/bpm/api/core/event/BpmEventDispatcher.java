package com.pig.easy.bpm.api.core.event;

/**
 * todo:
 *
 * @author : pig
 * @date : 2020/5/20 14:58
 */
public interface BpmEventDispatcher{

    /**
     * Adds an event-listener which will be notified of ALL events by the dispatcher.
     *
     * @param listenerToAdd
     *            the listener to add
     */
    void addEventListener(BpmEventListener listenerToAdd);

    /**
     * Adds an event-listener which will only be notified when an event of the given types occurs.
     *
     * @param listenerToAdd
     *            the listener to add
     * @param types
     *            types of events the listener should be notified for
     */
    void addEventListener(BpmEventListener listenerToAdd, BpmEventType... types);

    /**
     * Removes the given listener from this dispatcher. The listener will no longer be notified, regardless of the type(s) it was registered for in the first place.
     *
     * @param listenerToRemove
     *            listener to remove
     */
    void removeEventListener(BpmEventListener listenerToRemove);

    /**
     * Dispatches the given event to any listeners that are registered.
     *
     * @param event
     *            event to dispatch.
     */
    void dispatchEvent(BpmEvent event);

    /**
     * @param enabled
     *            true, if event dispatching should be enabled.
     */
    void setEnabled(boolean enabled);

    /**
     * @return true, if event dispatcher is enabled.
     */
    boolean isEnabled();


}
