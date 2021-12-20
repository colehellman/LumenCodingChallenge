package classes;

public class Records
{
    public final String r1, r2;

    public Records(final String r1, final String r2)
    {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((r1 == null) ? 0 : r1.hashCode());
        result = prime * result + ((r2 == null) ? 0 : r2.hashCode());
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
        if (!(obj instanceof Records))
        {
            return false;
        }
        Records other = (Records) obj;
        if (r1 == null)
        {
            if (other.r1 != null)
            {
                return false;
            }
        }
        else if (!r1.equals(other.r1))
        {
            return false;
        }
        if (r2 == null)
        {
            if (other.r2 != null)
            {
                return false;
            }
        }
        else if (!r2.equals(other.r2))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Records1and2 [r1=").append(r1).append(", r2=").append(r2).append("]");
        return builder.toString();
    }

}