package net.minecraft.server;
import java.util.Arrays;
import java.util.List;

public class CommandTell extends CommandAbstract {

   public List b() {
      return Arrays.asList(new String[]{"w", "msg"});
   }

   public String getCommand() {
      return "tell";
   }

   public int a() {
      return 0;
   }

   public String c(ICommandListener var1) {
      return "commands.message.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 2) {
         throw new ExceptionUsage("commands.message.usage", new Object[0]);
      } else {
         EntityPlayer var3 = a(var1, var2[0]);
         if(var3 == var1) {
            throw new ExceptionPlayerNotFound("commands.message.sameTarget", new Object[0]);
         } else {
            IChatBaseComponent var4 = b(var1, var2, 1, !(var1 instanceof EntityHuman));
            ChatMessage var5 = new ChatMessage("commands.message.display.incoming", new Object[]{var1.getScoreboardDisplayName(), var4.f()});
            ChatMessage var6 = new ChatMessage("commands.message.display.outgoing", new Object[]{var3.getScoreboardDisplayName(), var4.f()});
            var5.getChatModifier().setColor(EnumChatFormat.GRAY).b(Boolean.valueOf(true));
            var6.getChatModifier().setColor(EnumChatFormat.GRAY).b(Boolean.valueOf(true));
            var3.sendMessage((IChatBaseComponent)var5);
            var1.sendMessage(var6);
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return a(var2, MinecraftServer.M().I());
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }
}
