package net.minecraft.server;
import java.util.List;
import java.util.Map;

public interface ICommandHandler {

   int a(ICommandListener var1, String var2);

   List a(ICommandListener var1, String var2, Location var3);

   List a(ICommandListener var1);

   Map a();
}
