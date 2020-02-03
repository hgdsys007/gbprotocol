package ai.sangmado.jt808.protocol.message.codec.impl;

import ai.sangmado.jt808.protocol.ISpecificationContext;
import ai.sangmado.jt808.protocol.message.codec.IJT808MessageBufferReader;
import ai.sangmado.jt808.protocol.utils.BCD;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 基于 ByteBuffer 的读取层实现 (尝试设计，目前没实际意义)
 */
public class JT808MessageByteBufferReader implements IJT808MessageBufferReader {
    private ISpecificationContext ctx;
    private ByteBuffer buf;

    public JT808MessageByteBufferReader(ISpecificationContext ctx, ByteBuffer buf) {
        this.ctx = ctx;
        this.buf = buf;
    }

    private boolean isBigEndian() {
        return this.buf.order() == ByteOrder.BIG_ENDIAN;
    }

    @Override
    public boolean isReadable() {
        return buf.hasRemaining();
    }

    @Override
    public int readableBytes() {
        return buf.remaining();
    }

    @Override
    public byte readByte() {
        return buf.get();
    }

    @SuppressWarnings("IfStatementWithIdenticalBranches")
    @Override
    public int readWord() {
        if (isBigEndian()) {
            return (buf.get() << 8) | (buf.get());
        } else {
            return (buf.get()) | (buf.get() << 8);
        }
    }

    @Override
    public long readDWord() {
        if (isBigEndian()) {
            return (buf.get() << 24) | (buf.get() << 16) | (buf.get() << 8) | (buf.get());
        } else {
            return (buf.get()) | (buf.get() << 8) | (buf.get() << 16) | (buf.get() << 24);
        }
    }

    @Override
    public byte[] readBytes(int length) {
        byte[] x = new byte[length];
        buf.get(x, 0, x.length);
        return x;
    }

    @Override
    public String readBCD(int length) {
        byte[] x = readBytes(length);
        return BCD.bcd2BCDString(x);
    }

    @Override
    public String readString(int length) {
        byte[] x = readBytes(length);
        return ctx.getCharset().decode(ByteBuffer.wrap(x, 0, x.length)).toString();
    }

    @Override
    public String readStringRemaining() {
        return readString(buf.remaining());
    }
}
