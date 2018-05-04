// !API_VERSION: 1.2
// !USE_EXPERIMENTAL: kotlin.Experimental
// !DIAGNOSTICS: -INVISIBLE_MEMBER -INVISIBLE_REFERENCE -NEWER_VERSION_IN_SINCE_KOTLIN -UNUSED_PARAMETER

@SinceKotlin("1.3")
fun newPublishedFun() {}


@Experimental
annotation class Marker

@SinceKotlin("1.3")
@WasExperimental(Marker::class)
fun newFunExperimentalInThePast() {}

@SinceKotlin("1.3")
@WasExperimental(Marker::class)
val newValExperimentalInThePast = ""

@SinceKotlin("1.3")
@WasExperimental(Marker::class)
class NewClassExperimentalInThePast

fun use1(c: <!UNRESOLVED_REFERENCE!>NewClassExperimentalInThePast<!>) {
    <!UNRESOLVED_REFERENCE!>newPublishedFun<!>()
    <!UNRESOLVED_REFERENCE!>newFunExperimentalInThePast<!>()
    <!UNRESOLVED_REFERENCE!>newValExperimentalInThePast<!>
    <!UNRESOLVED_REFERENCE!>NewClassExperimentalInThePast<!>()
}

@UseExperimental(Marker::class)
fun use2(c: NewClassExperimentalInThePast) {
    <!UNRESOLVED_REFERENCE!>newPublishedFun<!>()
    newFunExperimentalInThePast()
    newValExperimentalInThePast
    NewClassExperimentalInThePast()
}

@Marker
fun use3(c: NewClassExperimentalInThePast) {
    <!UNRESOLVED_REFERENCE!>newPublishedFun<!>()
    newFunExperimentalInThePast()
    newValExperimentalInThePast
    NewClassExperimentalInThePast()
}
