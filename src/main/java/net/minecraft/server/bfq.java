package net.minecraft.server;
import java.io.IOException;


public interface bfq {

   bfh a(World var1, int var2, int var3) throws IOException;

   void a(World var1, bfh var2) throws IOException, ExceptionWorldConflict;

   void b(World var1, bfh var2);

   void a();

   void b();
}
