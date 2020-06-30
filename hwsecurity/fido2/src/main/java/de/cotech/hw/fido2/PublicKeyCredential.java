/*
 * Copyright (C) 2018-2020 Confidential Technologies GmbH
 *
 * You can purchase a commercial license at https://hwsecurity.dev.
 * Buying such a license is mandatory as soon as you develop commercial
 * activities involving this program without disclosing the source code
 * of your own applications.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.cotech.hw.fido2;


import com.google.auto.value.AutoValue;
import de.cotech.hw.fido2.domain.AuthenticatorResponse;
import de.cotech.hw.fido2.internal.utils.WebsafeBase64;
import de.cotech.hw.fido2.internal.webauthn.WebauthnResponse;


@AutoValue
public abstract class PublicKeyCredential extends Credential implements WebauthnResponse {
    public abstract byte[] rawId();
    public abstract AuthenticatorResponse response();

    public String id() {
        return WebsafeBase64.encodeToString(rawId());
    }

    @Override
    public String type() {
        return "public-key";
    }

    public static PublicKeyCredential create(byte[] rawId, AuthenticatorResponse response) {
        return new AutoValue_PublicKeyCredential(rawId, response);
    }
}
