package org.ice1000.texgen.tex;

import org.jetbrains.annotations.NotNull;

public interface TeXEnvironment {

  @NotNull BlockComponent create(@NotNull TeXComponent comp);
}
