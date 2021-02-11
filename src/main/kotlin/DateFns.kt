import utils.picker.IUtils

@JsModule(import = "@date-io/date-fns")
@JsNonModule
external val dateFnsModule: dynamic

@Suppress("UnsafeCastFromDynamic")
val dateFnsUtils: IUtils = dateFnsModule.default