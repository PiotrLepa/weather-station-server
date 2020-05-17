package pl.piotr.weatherstation.core.converter

interface ConverterWithArgs<T, S, A> {

  fun convert(from: T, args: A): S
}