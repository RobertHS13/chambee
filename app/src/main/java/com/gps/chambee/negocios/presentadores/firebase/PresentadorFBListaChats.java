package com.gps.chambee.negocios.presentadores.firebase;

import com.google.firebase.database.DataSnapshot;
import com.gps.chambee.entidades.vistas.VistaChat;

import java.util.ArrayList;
import java.util.List;

public class PresentadorFBListaChats extends PresentadorFirebase<List<VistaChat>> {

    private String idEmisor;

    public PresentadorFBListaChats(String idEmisor) {
        this.idEmisor = idEmisor;
    }

    @Override
    public List<VistaChat> procesar(DataSnapshot snapshot) {
        List<VistaChat> chats = new ArrayList<>();

        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
            VistaChat chat = dataSnapshot.getValue(VistaChat.class);

            assert chat != null;

            if (chat.getNombreUsuario().equals(idEmisor))
                chats.add(chat);
        }

        return chats;
    }

}
