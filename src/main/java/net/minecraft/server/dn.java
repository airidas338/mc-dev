package net.minecraft.server;

public class dn extends CommandException {

   public dn() {
      this("commands.generic.notFound", new Object[0]);
   }

   public dn(String var1, Object ... var2) {
      super(var1, var2);
   }
}
