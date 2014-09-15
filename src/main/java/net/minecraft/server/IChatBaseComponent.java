package net.minecraft.server;
import java.util.List;

public interface IChatBaseComponent extends Iterable {

   IChatBaseComponent setChatModifier(ChatModifier var1);

   ChatModifier getChatModifier();

   IChatBaseComponent a(String var1);

   IChatBaseComponent a(IChatBaseComponent var1);

   String e();

   String c();

   List a();

   IChatBaseComponent f();
}
