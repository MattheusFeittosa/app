import android.text.Editable
import android.text.TextWatcher

class CPFCNPJFormatter(private val isPersonPhysical: Boolean) : TextWatcher {

    private var isFormatting = false
    private var deletingHyphen = false
    private var hyphenStart = 0
    private var deletingBackward = false

    override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
        if (count > 0 && charSequence?.get(start) == '-') {
            deletingHyphen = true
            hyphenStart = start
        } else {
            deletingHyphen = false
        }

        deletingBackward = count > after
    }

    override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(editable: Editable?) {
        if (!isFormatting) {
            isFormatting = true

            if (deletingHyphen && hyphenStart > 0) {
                editable?.delete(hyphenStart - 1, hyphenStart)
            }

            val length = editable?.length ?: 0

            if (isPersonPhysical) {
                formatCPF(editable, length)
            } else {
                formatCNPJ(editable, length)
            }

            isFormatting = false
        }
    }

    private fun formatCPF(editable: Editable?, length: Int) {
        if (length > MAX_CPF_LENGTH) {
            editable?.delete(MAX_CPF_LENGTH, length)
        } else if (length > 3 && editable?.get(2) != '.') {
            editable?.insert(2, ".")
        } else if (length > 7 && editable?.get(6) != '.') {
            editable?.insert(6, ".")
        } else if (length > 11 && editable?.get(10) != '-') {
            editable?.insert(10, "-")
        }
    }

    private fun formatCNPJ(editable: Editable?, length: Int) {
        if (length > MAX_CNPJ_LENGTH) {
            editable?.delete(MAX_CNPJ_LENGTH, length)
        } else if (length > 2 && editable?.get(2) != '.') {
            editable?.insert(2, ".")
        } else if (length > 6 && editable?.get(6) != '.') {
            editable?.insert(6, ".")
        } else if (length > 10 && editable?.get(10) != '/') {
            editable?.insert(10, "/")
        } else if (length > 15 && editable?.get(15) != '-') {
            editable?.insert(15, "-")
        }
    }

    companion object {
        private const val MAX_CNPJ_LENGTH = 18
        private const val MAX_CPF_LENGTH = 14
    }
}
