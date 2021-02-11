import com.ccfraser.muirwik.components.child
import react.*
import utils.picker.IUtils

@Suppress("UnsafeCastFromDynamic")
private val localizationProviderComponent: RComponent<LocalizationProviderProps, RState> =
    materialUIPickerModule.LocalizationProvider

interface LocalizationProviderProps : RProps {
    var dateAdapter: IUtils?
}

fun RBuilder.mPickerLocalizationProvider(
    dateAdapter: IUtils? = null,
    handler: RHandler<LocalizationProviderProps>? = null
) = child(localizationProviderComponent) {
    dateAdapter?.let {
        attrs.dateAdapter = it
    }
    handler?.invoke(this)
}