package classes;

public class Values
{
    public final String v1, v2;

    public Values(final String v1, final String v2)
    {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
        result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Values))
        {
            return false;
        }
        Values other = (Values) obj;
        if (v1 == null)
        {
            if (other.v1 != null)
            {
                return false;
            }
        }
        else if (!v1.equals(other.v1))
        {
            return false;
        }
        if (v2 == null)
        {
            if (other.v2 != null)
            {
                return false;
            }
        }
        else if (!v2.equals(other.v2))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Values1and2 [v1=").append(v1).append(", v2=").append(v2).append("]");
        return builder.toString();
    }

}