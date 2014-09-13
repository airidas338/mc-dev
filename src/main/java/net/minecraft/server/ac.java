package net.minecraft.server;
import java.io.IOException;
import java.util.List;

public interface ac extends Comparable {

   String c();

   String c(ICommandSender var1);

   List b();

   void a(ICommandSender var1, String[] var2) throws di, IOException;

   boolean a(ICommandSender var1);

   List a(ICommandSender var1, String[] var2, Location var3);

   boolean b(String[] var1, int var2);
}
