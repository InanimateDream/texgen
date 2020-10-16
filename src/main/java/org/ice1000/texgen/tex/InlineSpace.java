package org.ice1000.texgen.tex;

import org.jetbrains.annotations.NotNull;

public class InlineSpace {
  public static @NotNull InlineComponent PLAINSPACE = () -> " ";
  public static @NotNull InlineComponent INTERWORD = () -> "\\ ";
  public static @NotNull InlineComponent QUADSPACE = () -> "\\quad";
  public static @NotNull InlineComponent DOUBLEQUAD = () -> "\\qquad";
  public static @NotNull InlineComponent THINSPACE = () -> "\\,";
  public static @NotNull InlineComponent MEDIUMSPACE = () -> "\\:";
  public static @NotNull InlineComponent THICKSPACE = () -> "\\;";
  public static @NotNull InlineComponent NEGATIVESPACE = () -> "\\!";
}
