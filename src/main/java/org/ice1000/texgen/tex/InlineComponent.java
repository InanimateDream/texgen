package org.ice1000.texgen.tex;

import org.jetbrains.annotations.NotNull;

public interface InlineComponent extends TeXComponent {

  @Override
  default <T> @NotNull T accept(@NotNull TeXComponentVisitor<T> v) {
    return v.visitInlineComponent(this);
  }
}
