package org.ice1000.texgen.tex;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface TeXComponent {
  @Contract(pure = true)
  @NotNull CharSequence toCode();

  <T> @NotNull T accept(@NotNull TeXComponentVisitor<T> v);
}
