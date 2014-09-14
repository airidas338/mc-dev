package net.minecraft.server;

public interface Convertable {

   IDataManager a(String var1, boolean var2);

   void d();

   boolean isConvertable(String var1);

   boolean b(String var1);

   boolean convert(String var1, IProgressUpdate var2);
}
