//588. Design In-Memory File System
//Scarlett Chen; 5/21/2017
// LeetCode Weekly Contest 33
/**
Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.

readContentFromFile: Given a file path, return its content in string format.

Example:
Input: 
["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
Output:
[null,[],null,null,["a"],"hello"]
**/
public class FileSystem {
    File root;
    class File{
        Map<String, File> map = new HashMap<String, File>();
        String content = "";
        boolean isFile = false;
    }

    public FileSystem() {
        root = new File();
        
    }
    
    public List<String> ls(String path) {
        String[] paths = path.split("/");
        File cur = root;
        List<String> files = new ArrayList<String>();
        for (String p: paths) {
            if (p.isEmpty()) continue;
            if (!cur.map.containsKey(p)) break;
            cur = cur.map.get(p);
            //System.out.println("file name: "+p +", isFile: "+cur.isFile);
            if (cur.isFile) {
                files.add(p);
                return files;
            }
        }
        for (String each: cur.map.keySet()) files.add(each);
        Collections.sort(files);
        return files;
        
    }
    
    public void mkdir(String path) {
        String[] paths = path.split("/");
        File cur = root;
        for (String p: paths) {
            if (p.isEmpty()) continue;
            if (!cur.map.containsKey(p)) {
                cur.map.put(p, new File());
            }
            cur = cur.map.get(p);
            
        }

        
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] paths = filePath.split("/");
        File cur = root;
        for (String p: paths) {
            if (p.isEmpty()) continue;
            if (!cur.map.containsKey(p)) {
                cur.map.put(p, new File());
            }
            cur = cur.map.get(p);
        }
        cur.isFile = true;
        cur.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        String[] paths = filePath.split("/");
        File cur = root;
        for (String p: paths) {
            if (p.isEmpty()) continue;
            if (!cur.map.containsKey(p)) break;
            cur = cur.map.get(p);
        }
        return cur.content;      
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
