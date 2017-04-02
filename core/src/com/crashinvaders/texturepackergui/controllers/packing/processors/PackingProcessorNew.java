package com.crashinvaders.texturepackergui.controllers.packing.processors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.crashinvaders.texturepackergui.services.model.PackModel;
import com.crashinvaders.texturepackergui.utils.packprocessing.PackProcessingNode;
import com.crashinvaders.texturepackergui.utils.packprocessing.PackProcessor;
import com.crashinvaders.texturepackergui.utils.packprocessing.PackagingHandler;

import java.io.File;

public class PackingProcessorNew implements PackProcessor {
    @Override
    public void processPackage(PackProcessingNode node) throws Exception {
        PackModel pack = node.getPack();
        String settingsOrigExtension = pack.getSettings().atlasExtension;

        System.out.println("Packing started");

        String filename = pack.getCanonicalFilename();
        if (filename.lastIndexOf(".") > -1) {
            String extension = filename.substring(filename.lastIndexOf("."));
            filename = filename.substring(0, filename.lastIndexOf("."));
            pack.getSettings().atlasExtension = extension;
        } else {
            pack.getSettings().atlasExtension = "";
        }

        PackagingHandler packagingHandler = new PackagingHandler(pack);
        packagingHandler.pack();

        pack.getSettings().atlasExtension = settingsOrigExtension;

        System.out.println("Packing done");
    }
}
