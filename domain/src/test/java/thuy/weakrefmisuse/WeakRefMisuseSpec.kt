package thuy.weakrefmisuse

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

object WeakRefMisuseSpec : Spek({
  val publisher = Publisher()
  val subscriber = Subscriber(publisher)

  given("a publisher and a subscriber") {
    it("should be that the subscriber should receive all events from the publisher") {
      (0..5).forEach {
        publisher.publish(it)
      }

      // Attempt to clean up weak references.
      System.gc()

      (6..10).forEach {
        publisher.publish(it)
      }

      assertThat(subscriber.events).containsExactlyElementsOf((0..10))
    }
  }
})
