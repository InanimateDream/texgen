package org.ice1000.texgen.tex;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Join implements InlineComponent {
  private final @NotNull Stream<@NotNull ? extends InlineComponent> content;
  private final @NotNull TeXComponent delimiter;

  public Join(@NotNull Stream<@NotNull ? extends InlineComponent> content, TeXComponent delimiter) {
    this.content = content;
    this.delimiter = delimiter;
  }

  @Override
  @Contract(pure = true)
  public @NotNull CharSequence toCode() {
    return content
      .map(TeXComponent::toCode)
      .collect(Collectors.joining(delimiter.toCode()));
  }
}
