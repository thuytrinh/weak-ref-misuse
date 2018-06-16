package thuy.weakrefmisuse

import java.lang.ref.WeakReference

typealias Event = Int
typealias Callback<T> = (T) -> Unit

class Publisher {
  private var _callback: WeakReference<Callback<Event>?>? = null

  var callback: Callback<Event>?
    get() = _callback?.get()
    set(value) {
      _callback = WeakReference(value)
    }

  fun publish(event: Event) {
    println("Published ⟶ $event")
    _callback?.get()?.invoke(event)
  }
}
