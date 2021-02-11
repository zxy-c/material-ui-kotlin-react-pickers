import kotlinext.js.Object
import kotlinext.js.asJsObject

fun <T> Object.toMap(): Map<String, T> {
    val keys = Object.keys(this)
    return keys.map {
        it to this.unsafeCast<dynamic>()[it]
    }.toMap()
}


fun <T> Any.toJsObjectMap(): Map<String, T> {
    return if (this is Map<*, *>) {
        this.unsafeCast<Map<String, T>>()
    } else {
        this.asJsObject().toMap()
    }
}

fun <T : Any> T.mergeFrom(o2: T) {
    for (entry in o2.toJsObjectMap<Any>()) {
        this.asDynamic()[entry.key] = entry.value
    }
}