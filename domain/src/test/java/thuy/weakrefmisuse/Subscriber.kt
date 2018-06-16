package thuy.weakrefmisuse

class Subscriber(publisher: Publisher) {
  var events: List<Event> = emptyList()

  private val callback: Callback<Event> = object : Callback<Event> {
    override fun invoke(event: Event) {
      events += event
      println("Received ⟵ $event")
    }
  }

  init {
    publisher.callback = callback
  }
}
