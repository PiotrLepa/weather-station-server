package pl.piotr.weatherstation.core.converter

interface Converter<T, S> {

  fun convert(from: T): S
}