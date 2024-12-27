import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class TheLocations {
    private val parser = InputParser(
        """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
        """.trimIndent()
    )

    @Test
    fun `parses the two lists of numbers`() {
        assertThat(Locations(parser.lists[0]).list).containsExactly(3, 4, 2, 1, 3, 3)
        assertThat(Locations(parser.lists[1]).list).containsExactly(4, 3, 5, 3, 9, 3)
    }
}