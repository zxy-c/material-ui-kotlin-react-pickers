import com.ccfraser.muirwik.components.*
import react.*
import styled.StyledHandler
import kotlin.js.Date

@Suppress("UnsafeCastFromDynamic")
private val timePickerComponent: RComponent<MTimePickerProps, RState> = materialUIPickerModule.TimePicker

interface MTimePickerProps : StyledPropsWithCommonAttributes {
    var label: String?
    var value: Date?
    var onChange: OnChange?
    var renderInput: TimePickerRenderInput?
    var autoOk: Boolean?
    var ampm: Boolean?
}

typealias OnChange = ((date: Date) -> Unit)
typealias TimePickerRenderInput = ((props: MTextFieldProps) -> ReactElement)

fun RBuilder.mTimePicker(
    label: String? = null,
    value: Date? = null,
    onChange: OnChange? = null,
    renderInput: TimePickerRenderInput = {
        buildElement {
            mTextField(it.label) {
                attrs.mergeFrom(it)
            }
        }
    },
    autoOk: Boolean? = null,
    ampm: Boolean? = null,

    className: String? = null,
    handler: StyledHandler<MTimePickerProps>? = null
) = createStyled(timePickerComponent) {
    label?.let {
        attrs.label = it
    }
    value?.let {
        attrs.value = it
    }
    onChange?.let {
        attrs.onChange = it
    }
    attrs.renderInput = renderInput
    autoOk?.let {
        attrs.autoOk = it
    }
    ampm?.let {
        attrs.ampm = it
    }

    setStyledPropsAndRunHandler(className, handler)
}