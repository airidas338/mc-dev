package net.minecraft.server;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

class py implements ActionListener {

   // $FF: synthetic field
   final JTextField a;
   // $FF: synthetic field
   final pw b;


   py(pw var1, JTextField var2) {
      this.b = var1;
      this.a = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = this.a.getText().trim();
      if(var2.length() > 0) {
         pw.a(this.b).a(var2, (ICommandSender)MinecraftServer.M());
      }

      this.a.setText("");
   }
}
