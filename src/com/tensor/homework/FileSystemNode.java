package com.tensor.homework;

import java.util.ArrayList;

interface FileSystemNode {

    FileSystemNode getParent();

    String getName();

    String getPath();

    void setParent(FileSystemNode parent);

}

class AbstractFileSystemNode implements FileSystemNode {

    private String name;
    private FileSystemNode parent;

    public AbstractFileSystemNode(String name, FileSystemNode parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public final FileSystemNode getParent() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public final String getPath() {
        if (parent == null) return name;
        return parent.getPath() + "/" + name;
    }

    @Override
    public void setParent(FileSystemNode parent) {
        this.parent = parent;
    }

}

class Folder extends AbstractFileSystemNode {
    ArrayList<FileSystemNode> content;

    public Folder(String name, FileSystemNode parent, ArrayList<FileSystemNode> content) {
        super(name, parent);
        this.content = content;
        if (content != null)
            for (FileSystemNode sn : this.content) {
                sn.setParent(this);
            }
    }

    public ArrayList<FileSystemNode> getChildElements() {
        return content;
    }

    public String textView(int i) { // i - количество табов
        String view = "";
        for (int j = 0; j < i; j++) view += "\t";
        view += "/ " + getName() + "\n";
        i++;
        if (content != null)
            for (FileSystemNode sn : content) {
                if (sn instanceof File) {
                    for (int j = 0; j < i; j++) view += "\t";
                    view += "" + sn.getName() + "\n";
                } else if (sn instanceof Folder) {
                    view += ((Folder) sn).textView(i);
                }
            }
        return view;
    }

    @Override
    public String toString() {
        return textView(0);
    }
}

class File extends AbstractFileSystemNode {
    public File(String name, FileSystemNode parent) {
        super(name, parent);
    }

    public String getExtension() {
        return getName().split("\\.")[getName().split("\\.").length - 1];
    }
}






