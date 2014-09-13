package net.minecraft.server;
import java.util.List;
import java.util.Map;

public interface ICommandHandler {

   int a(ICommandSender var1, String var2);

   List a(ICommandSender var1, String var2, Location var3);

   List a(ICommandSender var1);

   Map a();
}
