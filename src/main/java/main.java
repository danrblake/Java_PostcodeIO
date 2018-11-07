public class main {
    public static void main(String[] args) {
        PostCodeInfoParser postCodeInfoParser = new PostCodeInfoParser();
        HTTPManagerPost HTTPManagerPost = new HTTPManagerPost();
        String[] postCodesToLook = {"ha72ag","kt13ds"};
        HTTPManagerPost.getAndStorePostCodeData(postCodesToLook);
        System.out.println(HTTPManagerPost.getRequestedPostCodeString());
    }
}

