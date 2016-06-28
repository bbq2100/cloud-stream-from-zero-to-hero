package github.qabbasi.cloudstream.cloudstream;

public class TwitterMessage {

    public String created_at;

    public Long id;

    public String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwitterMessage that = (TwitterMessage) o;

        if (created_at != null ? !created_at.equals(that.created_at) : that.created_at != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return text != null ? text.equals(that.text) : that.text == null;

    }

    @Override
    public int hashCode() {
        int result = created_at != null ? created_at.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TwitterMessage{");
        sb.append("created_at='").append(created_at).append('\'');
        sb.append(", id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
