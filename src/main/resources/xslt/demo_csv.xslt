<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="3.0">
    <xsl:output indent="no" method="text" omit-xml-declaration="yes"/>
    <xsl:template match="/products" name="xsl:initial-template">
        <xsl:for-each select="product">
            <xsl:value-of select="@nr"/>,<xsl:value-of select="name"/>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
