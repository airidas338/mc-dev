package net.minecraft.server;


public interface ICommandListener {

   String d_();

   IChatBaseComponent e_();

   void a(IChatBaseComponent var1);

   boolean a(int var1, String var2);

   Location c();

   Vec3D d();

   World e();

   Entity f();

   boolean t_();

   void a(ag var1, int var2);
}
