package org.ice1000.texgen.tex;

import org.jetbrains.annotations.NotNull;

public interface ComponentCreator extends TeXComponentVisitor<TeXComponent> {
  @NotNull CharSequence toCode(@NotNull TeXComponent comp);

  @Override
  default @NotNull TeXComponent visitInlineComponent(@NotNull InlineComponent inl) {
    return (InlineComponent) () -> toCode(inl);
  }

  @Override
  default @NotNull TeXComponent visitBlockComponent(@NotNull BlockComponent inr) {
    return (BlockComponent) () -> toCode(inr);
  }
}
