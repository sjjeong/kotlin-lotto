package calculator

import java.lang.RuntimeException

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        val numbers = getNumberTexts(text)
        return if (numbers.size == 1) {
            text.parseNumber()
        } else {
            numbers.map { it.parseNumber() }.sum()
        }
    }

    private fun getNumberTexts(text: String): List<String> {
        val result = Regex(REGEX_PATTERN).find(text)
        return if (result != null) {
            val customDelimiter = result.groupValues[1]
            result.groupValues[2].split(DELIMITER_COMMA, DELIMITER_COLON, customDelimiter)
        } else {
            text.split(DELIMITER_COMMA, DELIMITER_COLON)
        }
    }

    private fun String.parseNumber() = toInt().also { number ->
        if (number < 0) throw RuntimeException()
    }

    companion object {
        private const val REGEX_PATTERN = "//(.)\n(.*)"
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
    }

}