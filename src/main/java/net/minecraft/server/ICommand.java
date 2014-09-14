package net.minecraft.server;
import java.io.IOException;
import java.util.List;

public interface ICommand extends Comparable {

   String c();

   String c(ICommandListener var1);

   List b();

   void a(ICommandListener var1, String[] var2) throws CommandException, IOException;

   boolean a(ICommandListener var1);

   List a(ICommandListener var1, String[] var2, Location var3);

   boolean b(String[] var1, int var2);
}
