package lotto.views

object InputView {

    tailrec fun askWinningLotto(): String {
        println(WINNING_LOTTO_QUESTION)
        return readLine() ?: askWinningLotto()
    }

    tailrec fun askLottoBudget(): Int {
        println(LOTTO_BUDGET_QUESTION)
        return readLine()?.toIntOrNull() ?: askLottoBudget()
    }

    tailrec fun askBonusNumber(): Int {
        println(BONUS_NUMBER_QUESTION)
        return readLine()?.toIntOrNull() ?: askBonusNumber()
    }

    private const val LOTTO_BUDGET_QUESTION = "구입금액을 입력해 주세요."
    private const val WINNING_LOTTO_QUESTION = "지난 주 당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요."
}