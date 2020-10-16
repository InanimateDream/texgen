package org.ice1000.texgen.tex;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface TeXComponent {
  @Contract(pure = true)
  @NotNull CharSequence toCode();

  <T> @NotNull T accept(@NotNull TeXComponentVisitor<T> v);

  default @NotNull BlockComponent lift() {
    var creator = new TeXComponentVisitor<BlockComponent>() {
      @Override
      public @NotNull BlockComponent visitBlockComponent(@NotNull BlockComponent inr) {
        return inr;
      }

      @Override
      public @NotNull BlockComponent visitInlineComponent(@NotNull InlineComponent inl) {
        return inl::toCode;
      }
    };

    return this.accept(creator);
  }
}
