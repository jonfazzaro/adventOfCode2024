import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TheReportParser {
    
    @Test
    fun `parses input`() {
        val result = ReportParser("""7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9""")
        
        assertThat(result.reports.count()).isEqualTo(6)
        assertThat(result.reports[0].levels).containsExactly(7, 6, 4, 2, 1)
        assertThat(result.reports[1].levels).containsExactly(1, 2, 7, 8, 9)
    }
}