package net.minecraft.server;

public class ExceptionInvalidUUID extends CommandException {

   public ExceptionInvalidUUID() {
      this("commands.generic.entity.notFound", new Object[0]);
   }

   public ExceptionInvalidUUID(String var1, Object ... var2) {
      super(var1, var2);
   }
}
