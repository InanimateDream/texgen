package org.ice1000.texgen.tex;

import org.jetbrains.annotations.NotNull;

public class MathEnv implements TeXStyle {
  public static final MathEnv INSTANCE = new MathEnv();

  private static final TeXComponentVisitor<String> str = new TeXComponentVisitor<String>() {
    @Override
    public @NotNull String visitInlineComponent(@NotNull InlineComponent inl) {
      return "$%s$";
    }

    @Override
    public @NotNull String visitBlockComponent(@NotNull BlockComponent inr) {
      return "\\[\n%s\n\\]";
    }
  };

  private static final ComponentCreator creator = comp -> String.format(comp.accept(str), comp.toCode());

  @Override
  public @NotNull BlockComponent block(@NotNull BlockComponent comp) {
    return (BlockComponent) comp.accept(creator);
  }

  @Override
  public @NotNull InlineComponent inline(@NotNull InlineComponent comp) {
    return (InlineComponent) comp.accept(creator);
  }
}
