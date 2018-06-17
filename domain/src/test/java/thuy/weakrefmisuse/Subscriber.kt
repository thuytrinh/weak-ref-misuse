package thuy.weakrefmisuse

class Subscriber(publisher: Publisher) {
  var events: List<Event> = emptyList()

  init {
    publisher.callback = callback
  }

  private val callback: Callback<Event>
    get() = object : Callback<Event> {
      override fun invoke(event: Event) {
        events += event
        println("Received ⟵ $event")
      }
    }
}
