package net.minecraft.server;

public class ExceptionPlayerNotFound extends CommandException {

   public ExceptionPlayerNotFound() {
      this("commands.generic.player.notFound", new Object[0]);
   }

   public ExceptionPlayerNotFound(String var1, Object ... var2) {
      super(var1, var2);
   }
}
