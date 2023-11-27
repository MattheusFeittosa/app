import android.text.Editable
import android.text.TextWatcher

class DateOfBirthFormatter : TextWatcher {

    private var isFormatting = false

    override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(editable: Editable?) {
        if (!isFormatting) {
            isFormatting = true

            val input = editable.toString()

            if (input.length > 10) {
                editable?.delete(10, input.length)
            }

            if (input.length == 2 && !input.contains("/")) {
                editable?.append("/")
            } else if (input.length == 5 && !input.substring(3).contains("/")) {
                editable?.append("/")
            }

            isFormatting = false
        }
    }
}
