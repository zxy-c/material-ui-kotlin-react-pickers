import com.ccfraser.muirwik.components.*
import react.*
import styled.StyledHandler
import kotlin.js.Date

// https://v4-0-0-alpha-12.material-ui-pickers.dev/demo/daterangepicker
@Suppress("UnsafeCastFromDynamic")
private val dateRangePickerComponent: RComponent<MDateRangePickerProps, RState> = materialUIPickerModule.DateRangePicker

typealias DateRange = Array<Date?>

typealias OnDateRangePickerChange = (dateRange: DateRange) -> Unit

typealias DateRangePickerRenderInput = (startProps: MTextFieldProps, endProps: MTextFieldProps) -> dynamic

interface MDateRangePickerProps : StyledPropsWithCommonAttributes {
    var startText: String?
    var endText: String?
    var value: DateRange?
    var onChange: OnDateRangePickerChange?
    var renderInput: DateRangePickerRenderInput?
}

fun RBuilder.mDateRangePicker(
    startText: String? = null,
    endText: String? = null,
    value: DateRange? = arrayOf(null, null),
    onChange: OnDateRangePickerChange? = null,
    renderInput: DateRangePickerRenderInput = { startProps, endProps ->
        buildElements {
            mTextField("") {
                attrs.mergeFrom(startProps)
            }
            mDateRangeDelimiter {
                +"to"
            }
            mTextField("") {
                attrs.mergeFrom(endProps)
            }
        }
    },

    className: String? = null,
    handler: StyledHandler<MDateRangePickerProps>? = null
) = createStyled(dateRangePickerComponent) {
    startText?.let {
        attrs.startText = it
    }
    endText?.let {
        attrs.endText = it
    }
    onChange?.let {
        attrs.onChange = it
    }
    value?.let {
        attrs.value = it
    }
    attrs.renderInput = renderInput

    setStyledPropsAndRunHandler(className, handler)
}

// https://v4-0-0-alpha-12.material-ui-pickers.dev/demo/daterangepicker
@Suppress("UnsafeCastFromDynamic")
private val dateRangeDelimiterComponent: RComponent<RProps, RState> =
    materialUIPickerModule.DateRangeDelimiter

fun RBuilder.mDateRangeDelimiter(handler: RHandler<RProps>) = child(dateRangeDelimiterComponent) {
    handler(this)
}