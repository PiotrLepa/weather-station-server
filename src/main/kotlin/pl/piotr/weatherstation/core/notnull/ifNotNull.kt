package pl.piotr.weatherstation.core.notnull

inline fun <A, B, R> ifNotNull(a: A?, b: B?, code: (A, B) -> R): R? {
  if (a != null && b != null) {
    return code(a, b)
  }
  return null
}

inline fun <A, B, C, R> ifNotNull(a: A?, b: B?, c: C?, code: (A, B, C) -> R): R? {
  if (a != null && b != null && c != null) {
    return code(a, b, c)
  }
  return null
}

inline fun <A, B, C, D, R> ifNotNull(a: A?, b: B?, c: C?, d: D?, code: (A, B, C, D) -> R): R? {
  if (a != null && b != null && c != null && d != null) {
    return code(a, b, c, d)
  }
  return null
}
